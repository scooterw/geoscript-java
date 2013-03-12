package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LinearRing;
import org.opengeo.geoscript.geometry.Bounds;
import org.opengeo.geoscript.geometry.Geometry;

public class Polygon extends com.vividsolutions.jts.geom.Polygon {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public Polygon(LinearRing[] rings) {
    super(rings[0], java.util.Arrays.copyOfRange(rings, 1, rings.length), factory);
    Geometry.enhance(this);
  }

  public Polygon(double[][][] poly) {
    super(getShell(poly), getHoles(poly), factory);
    Geometry.enhance(this);
  }

  public Polygon(com.vividsolutions.jts.geom.Polygon p) {
    super(getShell(p), getHoles(p), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  public static LinearRing getShell(double[][][] poly) {
    Coordinate[] coordinates = new Coordinate[poly[0][0].length];

    for(int i = 0; i < poly[0].length; i++) {
      coordinates[i] = new Coordinate(poly[0][i][0], poly[0][i][1]);
    }

    LinearRing shell = factory.createLinearRing(coordinates);

    return shell;
  }

  public static LinearRing getShell(com.vividsolutions.jts.geom.Polygon p) {
    LinearRing shell = new LinearRing(p.getExteriorRing().getCoordinateSequence(), factory);
    return shell;
  }

  public static LinearRing[] getHoles(double[][][] poly) {
    LinearRing[] holes = new LinearRing[poly[0].length - 1];

    for(int i = 1; i < poly.length; i++) {
      Coordinate[] coordinates = new Coordinate[poly[i].length];

      for(int j = 0; j < poly[i].length; j++) {
        coordinates[j] = new Coordinate(poly[i][j][0], poly[i][j][1]);
      }

      holes[i - 1] = factory.createLinearRing(coordinates);
    }

    return holes;
  }

  public static LinearRing[] getHoles(com.vividsolutions.jts.geom.Polygon p) {
    LinearRing[] holes = new LinearRing[p.getNumInteriorRing()];

    for(int i = 0; i < p.getNumInteriorRing(); i++) {
      LinearRing ring = new LinearRing(p.getInteriorRingN(i).getCoordinateSequence(), factory);
      holes[i] = ring;
    }

    return holes;
  }
}
