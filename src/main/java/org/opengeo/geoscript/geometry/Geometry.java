package org.opengeo.geoscript.geometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.prep.PreparedGeometryFactory;
import com.vividsolutions.jts.simplify.DouglasPeuckerSimplifier;
import com.vividsolutions.jts.geom.prep.PreparedGeometry;
import com.vividsolutions.jts.operation.buffer.BufferOp;
import com.vividsolutions.jts.operation.buffer.BufferParameters;
import org.opengeo.geoscript.geometry.Bounds;
import org.opengeo.geoscript.geometry.Point;
import org.opengeo.geoscript.geometry.MultiPoint;
import org.opengeo.geoscript.geometry.LineString;
import org.opengeo.geoscript.geometry.MultiLineString;
import org.opengeo.geoscript.geometry.LinearRing;
import org.opengeo.geoscript.geometry.Polygon;
import org.opengeo.geoscript.geometry.MultiPolygon;

public class Geometry {
  private static GeometryFactory factory = new GeometryFactory();
  private static PreparedGeometryFactory prepFactory = new PreparedGeometryFactory();

  public static PreparedGeometry prepare(com.vividsolutions.jts.geom.Geometry geom) {
    return prepFactory.create(geom);
  }

  public static com.vividsolutions.jts.geom.Geometry simplify(com.vividsolutions.jts.geom.Geometry geom, double tolerance) {
    return DouglasPeuckerSimplifier.simplify(geom, tolerance);
  }

  public static void enhance(Point point) {
    point.setBounds(new Bounds(point.getEnvelopeInternal()));
  }

  public static void enhance(MultiPoint mp) {
    mp.setBounds(new Bounds(mp.getEnvelopeInternal()));
  }

  public static void enhance(LineString ls) {
    ls.setBounds(new Bounds(ls.getEnvelopeInternal()));
  }

  public static void enhance(MultiLineString mls) {
    mls.setBounds(new Bounds(mls.getEnvelopeInternal()));
  }

  public static void enhance(LinearRing lr) {
    lr.setBounds(new Bounds(lr.getEnvelopeInternal()));
  }

  public static void enhance(Polygon poly) {
    poly.setBounds(new Bounds(poly.getEnvelopeInternal()));
  }

  public static void enhance(MultiPolygon mp) {
    mp.setBounds(new Bounds(mp.getEnvelopeInternal()));
  }

  public static com.vividsolutions.jts.geom.Geometry buffer(com.vividsolutions.jts.geom.Geometry geom, double distance) {
    BufferParameters bp = new BufferParameters();
    bp.setSingleSided(false);
    return BufferOp.bufferOp(geom, distance, bp);
  }

  public static com.vividsolutions.jts.geom.Geometry buffer(com.vividsolutions.jts.geom.Geometry geom, double distance, boolean singleSided) {
    BufferParameters bp = new BufferParameters();
    bp.setSingleSided(singleSided);
    return BufferOp.bufferOp(geom, distance, bp);
  }

  public static Bounds bounds(com.vividsolutions.jts.geom.Geometry geom) {
    return new Bounds(geom.getEnvelopeInternal());
  }

  /*
  public static Point toGeoScript(com.vividsolutions.jts.geom.Point point) {
    return new Point(point);
  }

  public static LineString toGeoScript(com.vividsolutions.jts.geom.LineString ls) {
    return new LineString(ls);
  }

  public static Polygon toGeoScript(com.vividsolutions.jts.geom.Polygon poly) {
    return new Polygon(poly);
  }
  */
}
