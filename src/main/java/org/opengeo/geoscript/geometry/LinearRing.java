package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import org.opengeo.geoscript.geometry.Geometry;
import org.opengeo.geoscript.geometry.LineString;
import org.opengeo.geoscript.geometry.Bounds;

public class LinearRing extends com.vividsolutions.jts.geom.LinearRing {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public LinearRing(com.vividsolutions.jts.geom.LinearRing lr) {
    super(lr.getCoordinateSequence(), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  public LinearRing(double[][] lr) {
    super(new LineString(lr).getCoordinateSequence(), factory);
  }
}
