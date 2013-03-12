package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import org.opengeo.geoscript.geometry.Geometry;
import com.vividsolutions.jts.geom.LineString;
import org.opengeo.geoscript.geometry.Bounds;

public class MultiLineString extends com.vividsolutions.jts.geom.MultiLineString {
  private static GeometryFactory factory = new GeometryFactory();
  private Bounds bounds;

  public MultiLineString(com.vividsolutions.jts.geom.MultiLineString mls) {
    super(createLineStringArray(mls), factory);
    Geometry.enhance(this);
  }

  public Bounds getBounds() {
    return bounds;
  }

  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  private static LineString[] createLineStringArray(com.vividsolutions.jts.geom.MultiLineString mls) {
    LineString[] lineStrings = new LineString[mls.getNumGeometries()];

    for(int i = 0; i < lineStrings.length; i++) {
      lineStrings[i] = (LineString) mls.getGeometryN(i);
    }

    return lineStrings;
  }
}
