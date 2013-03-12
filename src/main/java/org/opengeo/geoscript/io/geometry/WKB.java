package org.opengeo.geoscript.io.geometry;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKBWriter;

public class WKB {
  public static Geometry read(String wkb) throws com.vividsolutions.jts.io.ParseException {
    WKBReader reader = new WKBReader();
    byte[] bytes = reader.hexToBytes(wkb);
    return reader.read(bytes);
  }

  public static Geometry read(byte[] wkb) throws com.vividsolutions.jts.io.ParseException {
    WKBReader reader = new WKBReader();
    return reader.read(wkb);
  }

  public static String write(Geometry geom) {
    WKBWriter writer = new WKBWriter();
    return writer.toHex(writer.write(geom));
  }
}
