package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Coordinate;
import org.opengeo.geoscript.geometry.Bounds;
import org.opengeo.geoscript.geometry.Geometry;

public class LineString extends com.vividsolutions.jts.geom.LineString {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public LineString(double[][] coordinates) {
    super(getCoordinateArray(coordinates).getCoordinateSequence(), factory);
    Geometry.enhance(this);
  }

  public LineString(com.vividsolutions.jts.geom.LineString ls) {
    super(ls.getCoordinateSequence(), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  private static com.vividsolutions.jts.geom.LineString getCoordinateArray(double[][] c) {
    Coordinate[] coordinates = new Coordinate[c.length];

    for (int i = 0; i < c.length; i++) {
      coordinates[i] = new Coordinate(c[i][0], c[i][1]);
    }

    com.vividsolutions.jts.geom.LineString ls = factory.createLineString(coordinates);

    return ls;
  }
}
