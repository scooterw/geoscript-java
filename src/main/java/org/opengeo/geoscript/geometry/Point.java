package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Coordinate;
import org.opengeo.geoscript.geometry.Bounds;
import org.opengeo.geoscript.geometry.Geometry;

public class Point extends com.vividsolutions.jts.geom.Point {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public Point() {
    this(0.0, 0.0);
  }

  public Point(double[] xy) {
    this(xy[0], xy[1]);
  }

  public Point(double x, double y) {
    this(factory.createPoint(new Coordinate(x, y)));
  }

  public Point(com.vividsolutions.jts.geom.Point p) {
    super(p.getCoordinateSequence(), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }
}
