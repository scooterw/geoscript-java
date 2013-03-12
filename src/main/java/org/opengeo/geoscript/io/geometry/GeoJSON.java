package org.opengeo.geoscript.io.geometry;

import java.io.StringReader;
import com.vividsolutions.jts.geom.Geometry;
import org.geotools.geojson.geom.GeometryJSON;

public class GeoJSON {
  public static String write(Geometry geom) {
    return new GeometryJSON().toString(geom);
  }

  public static Geometry read(String json) throws java.io.IOException {
    StringReader reader = new StringReader(json);
    return new GeometryJSON().read(reader);
  }
}
