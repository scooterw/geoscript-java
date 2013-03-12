package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import org.opengeo.geoscript.geometry.Bounds;
import org.opengeo.geoscript.geometry.Geometry;

public class MultiPolygon extends com.vividsolutions.jts.geom.MultiPolygon {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public MultiPolygon(com.vividsolutions.jts.geom.MultiPolygon mp) {
    super(createPolygonArray(mp), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  private static Polygon[] createPolygonArray(com.vividsolutions.jts.geom.MultiPolygon mp) {
    Polygon[] polygons = new Polygon[mp.getNumGeometries()];

    for(int i = 0; i < polygons.length; i++) {
      Polygon poly = (Polygon) mp.getGeometryN(i);
      LinearRing shell = new LinearRing(poly.getExteriorRing().getCoordinateSequence(), factory);
      polygons[i] = factory.createPolygon(shell, getHoles(poly));
    }

    return polygons;
  }

  private static LinearRing[] getHoles(Polygon poly) {
    LinearRing[] holes = new LinearRing[poly.getNumInteriorRing()];

    for(int i = 0; i < poly.getNumInteriorRing(); i++) {
      LinearRing ring = new LinearRing(poly.getInteriorRingN(i).getCoordinateSequence(), factory);
      holes[i] = ring;
    }

    return holes;
  }
}
