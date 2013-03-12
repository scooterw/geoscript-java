package org.opengeo.geoscript.io.geometry;

import java.io.StringReader;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

public class WKT {
  public static Geometry read(String wkt) throws com.vividsolutions.jts.io.ParseException {
    return new WKTReader().read(wkt);
  }

  public static String write(Geometry geom) {
    return new WKTWriter().write(geom);
  }
}
