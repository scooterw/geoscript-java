package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.opengeo.geoscript.geometry.Geometry;
import org.opengeo.geoscript.geometry.Bounds;

public class MultiPoint extends com.vividsolutions.jts.geom.MultiPoint {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public MultiPoint(Point[] points) {
    super(points, factory);
    Geometry.enhance(this);
  }

  public MultiPoint(com.vividsolutions.jts.geom.MultiPoint mp) {
    super(createPointArray(mp), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  private static Point[] createPointArray(com.vividsolutions.jts.geom.MultiPoint mp) {
    Point[] points = new Point[mp.getNumGeometries()];

    for(int i = 0; i < points.length; i++) {
      points[i] = factory.createPoint(mp.getGeometryN(i).getCoordinate());
    }

    return points;
  }
}
