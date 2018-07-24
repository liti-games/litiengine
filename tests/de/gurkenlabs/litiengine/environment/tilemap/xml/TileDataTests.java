package de.gurkenlabs.litiengine.environment.tilemap.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TileDataTests {

  @Test
  public void testBase64EncodingUncompressed() {
    String uncompressedBase64 = "AQAAAAIAAAACAAAAAgAAABIAAAARAAAAEQAAAAIAAAABAAAAEQAAABEAAAACAAAAEgAAABEAAAASAAAAAQAAABEAAAABAAAAEgAAABEAAAACAAAAEgAAABIAAAACAAAAAQAAABIAAAASAAAAAQAAAAEAAAACAAAAAgAAABEAAAACAAAAAgAAAAEAAAASAAAAEQAAABIAAAARAAAAAQAAAAIAAAABAAAAAgAAABEAAAASAAAAAQAAAAEAAAABAAAAAgAAAAIAAAABAAAAEgAAAAIAAAARAAAAAQAAAAEAAAASAAAAEgAAABIAAAACAAAAEQAAABIAAAARAAAAEQAAAAEAAAASAAAAEgAAABEAAAASAAAAAQAAAAIAAAACAAAAAQAAAAEAAAARAAAAAQAAAAEAAAACAAAAAQAAAAIAAAACAAAAEQAAABIAAAARAAAAAgAAAAIAAAABAAAAEgAAABEAAAABAAAAAgAAAAEAAAABAAAAEgAAAAEAAAARAAAAEgAAAAIAAAABAAAAAgAAAAIAAAASAAAAAgAAAAEAAAACAAAAAgAAABEAAAASAAAAAQAAAAEAAAABAAAAEQAAABEAAAARAAAAAgAAABEAAAASAAAAEgAAAAEAAAACAAAAEQAAAAEAAAABAAAAAQAAAAEAAAASAAAAAgAAABIAAMARAADAEQAAABIAAAACAAAAEgAAABEAAAARAAAAAgAAABEAAAABAAAAAgAAABEAAAACAAAAEQAAAAIAAAASAAAAAgAAABIAAAASAAAAAgAAwAEAAMABAAAAAgAAAAIAAAABAAAAEQAAAAIAAAASAAAAEgAAAAEAAAASAAAAAgAAAAIAAAACAAAAEgAAABEAAAACAAAAEgAAABIAAAASAAAAEgAAABIAAAASAAAAAgAAABIAAAARAAAAAgAAAAEAAAACAAAAAQAAAAIAAAACAAAAAgAAABEAAAACAAAAAQAAAAIAAAASAAAAEgAAAAEAAAACAAAAEQAAABEAAAASAAAAAgAAABIAAAACAAAAEgAAABIAAAASAAAAEgAAABIAAAASAAAAAQAAAAIAAAARAAAAEgAAABIAAAASAAAAAQAAABIAAAABAAAAEgAAAAIAAAABAAAAAgAAAAIAAAASAAAAEQAAAAIAAAARAAAAAQAAABIAAAASAAAAAQAAABEAAAASAAAAEQAAAAEAAAARAAAAEQAAAAEAAAABAAAAEgAAAAEAAAARAAAAAQAAAAEAAAARAAAAAgAAABEAAAACAAAAEQAAAAEAAAACAAAAAgAAABIAAAABAAAAEgAAAAEAAAACAAAAAQAAAAIAAAASAAAAAQAAABEAAAABAAAAEgAAAAEAAAARAAAAEgAAAAIAAAASAAAAEgAAABIAAAARAAAAEQAAAAIAAAABAAAAAQAAABEAAAASAAAAAQAAAAIAAAASAAAAAgAAABIAAAARAAAAEQAAAAEAAAACAAAAAQAAABIAAAACAAAAAQAAAAIAAAACAAAAAgAAABEAAAARAAAAEQAAAAIAAAASAAAAAgAAAAEAAAASAAAAAgAAABEAAAABAAAAEQAAABEAAAABAAAAAgAAABIAAAACAAAAEgAAAAIAAAACAAAAAQAAAAIAAAASAAAAEQAAAAEAAAASAAAAEQAAAAIAAAABAAAAAgAAAAEAAAARAAAAAQAAABIAAAARAAAAEQAAABEAAAASAAAAAgAAAAEAAAARAAAAEgAAABEAAAARAAAAAgAAAAEAAAACAAAAAQAAABIAAAABAAAAEQAAAAEAAAASAAAAEQAAABEAAAACAAAAAQAAABEAAAARAAAAAgAAABEAAAASAAAAAgAAABIAAAABAAAAAQAAABEAAAASAAAAEgAAAAEAAAASAAAAAQAAAAIAAAABAAAAAgAAAAEAAAACAAAAEgAAAAEAAAABAAAAEQAAAAIAAAACAAAAAgAAAAIAAAACAAAAEgAAABEAAAACAAAAEQAAABEAAAACAAAAAQAAABIAAAABAAAAAgAAABEAAAACAAAAEQAAAAIAAAASAAAAEQAAABIAAAACAAAAEQAAABIAAAARAAAAEgAAAAEAAAABAAAAEQAAABEAAAACAAAAAgAAABIAAAACAAAAEQAAABIAAAASAAAAEgAAABIAAAACAAAAEgAAABIAAAARAAAAAgAAABIAAAARAAAAAQAAAAIAAAABAAAAEgAAAAIAAAARAAAAEQAAABIAAAACAAAAAQAAABEAAAARAAAAEQAAABIAAAACAAAAEQAAAAIAAAARAAAAEQAAABEAAAARAAAAEQAAAAIAAAABAAAAAQAAABIAAAABAAAAEgAAABIAAAASAAAAAgAAAAEAAAACAAAAEgAAABIAAAASAAAAAQAAAAIAAAARAAAAAQAAABEAAAACAAAAEgAAABIAAAASAAAAEQAAAAIAAAACAAAAEQAAABIAAAACAAAAAgAAABEAAAASAAAAEQAAAAIAAAACAAAAAQAAAAEAAAASAAAAEgAAAAIAAAABAAAAAQAAAAIAAAARAAAAAgAAABEAAAACAAAAAgAAAAEAAAASAAAAEQAAAAEAAAASAAAAAgAAAAIAAAARAAAAAQAAABEAAAARAAAAEgAAAAIAAAACAAAAAQAAAAEAAAA=";

    TileData data = new TileData();
    data.setValue(uncompressedBase64);
    data.setEncoding(TileData.ENCODING_BASE64);
    List<Tile> tiles = data.parseTiles();
    assertEquals(500, tiles.size());
    assertEquals(1, tiles.get(0).getGridId());
    assertEquals(17, tiles.get(19).getGridId());
    assertEquals(18, tiles.get(405).getGridId());
    assertTrue(tiles.get(127).isFlippedHorizontally());
    assertTrue(tiles.get(127).isFlippedVertically());
    assertFalse(tiles.get(127).isFlippedDiagonally());
    assertEquals(18, tiles.get(127).getGridId());
  }

  @Test
  public void testBase64EncodingGzip() {
    String gzipBase64 = "H4sIAAAAAAAAC32VWw7DIAwEMTcw9z9sG6lIk+nCB0oCfq13cWqMMbHWd/VvPd+l732+cFbY3zYL/gv2hVyN91Lshm3BnnEq+E/4MvdSjB7v2o2LcUsx5/jHQfzGU4rF3q0QL+0l7D3e3GwbYmj5sE+OnfhvxeKTPtYD+2BdpBqSfrxsl7iY4Tz1xJhvea0/4yAe8+g+ulfUCDVpnZBzc+Gc9HUffGetQ+LzHKAtY1o3zJv6Qg6spXSPHde8GWOaSazJ59aDuUkxTvPvNDfdY/fzxpv5ow68rDnWYy37LrPG1p5njmeV74b15DxJIycevG981pLvj2vyXEjzMs0i4mY9t39AhdwnDtJ/wznYE+v/WR/aeI2n0AcAAA==";

    TileData data = new TileData();
    data.setValue(gzipBase64);
    data.setEncoding(TileData.ENCODING_BASE64);
    data.setCompression(TileData.COMPRESSION_GZIP);
    List<Tile> tiles = data.parseTiles();
    assertEquals(500, tiles.size());
    assertEquals(1, tiles.get(0).getGridId());
    assertEquals(17, tiles.get(19).getGridId());
    assertEquals(18, tiles.get(405).getGridId());
  }

  @Test
  public void testBase64EncodingZlib() {
    String zlibBase64 = "eJx9lVsOwyAMBDE3MPc/bBupSJPpwgdKAn6td3FqjDGx1nf1bz3fpe99vnBW2N82C/4L9oVcjfdS7IZtwZ5xKvhP+DL3Uowe79qNi3FLMef4x0H8xlOKxd6tEC/tJew93txsG2Jo+bBPjp34b8Xikz7WA/tgXaQakn68bJe4mOE89cSYb3mtP+MgHvPoPrpX1Ag1aZ2Qc3PhnPR1H3xnrUPi8xygLWNaN8yb+kIOrKV0jx3XvBljmkmsyefWg7lJMU7z7zQ33WP388ab+aMOvKw51mMt+y6zxtaeZ45nle+G9eQ8SSMnHrxvfNaS749r8lxI8zLNIuJmPbd/QIXcJw7Sf8M52BPr/1kf7O8SQA==";

    TileData data = new TileData();
    data.setValue(zlibBase64);
    data.setEncoding(TileData.ENCODING_BASE64);
    data.setCompression(TileData.COMPRESSION_ZLIB);
    List<Tile> tiles = data.parseTiles();
    assertEquals(500, tiles.size());
    assertEquals(1, tiles.get(0).getGridId());
    assertEquals(17, tiles.get(19).getGridId());
    assertEquals(18, tiles.get(405).getGridId());
  }

  @Test
  public void testCsvEncoding() {
    String csv = String.join("\n"
        , "1,2,2,2,18,17,17,2,1,17,17,2,18,17,18,1,17,1,18,17,"
        , "2,18,18,2,1,18,18,1,1,2,2,17,2,2,1,18,17,18,17,1,"
        , "2,1,2,17,18,1,1,1,2,2,1,18,2,17,1,1,18,18,18,2,"
        , "17,18,17,17,1,18,18,17,18,1,2,2,1,1,17,1,1,2,1,2,"
        , "2,17,18,17,2,2,1,18,17,1,2,1,1,18,1,17,18,2,1,2,"
        , "2,18,2,1,2,2,17,18,1,1,1,17,17,17,2,17,18,18,1,2,"
        , "17,1,1,1,1,18,2,3221225490,3221225489,17,18,2,18,17,17,2,17,1,2,17,"
        , "2,17,2,18,2,18,18,3221225474,3221225473,1,2,2,1,17,2,18,18,1,18,2,"
        , "2,2,18,17,2,18,18,18,18,18,18,2,18,17,2,1,2,1,2,2,"
        , "2,17,2,1,2,18,18,1,2,17,17,18,2,18,2,18,18,18,18,18,"
        , "18,1,2,17,18,18,18,1,18,1,18,2,1,2,2,18,17,2,17,1,"
        , "18,18,1,17,18,17,1,17,17,1,1,18,1,17,1,1,17,2,17,2,"
        , "17,1,2,2,18,1,18,1,2,1,2,18,1,17,1,18,1,17,18,2,"
        , "18,18,18,17,17,2,1,1,17,18,1,2,18,2,18,17,17,1,2,1,"
        , "18,2,1,2,2,2,17,17,17,2,18,2,1,18,2,17,1,17,17,1,"
        , "2,18,2,18,2,2,1,2,18,17,1,18,17,2,1,2,1,17,1,18,"
        , "17,17,17,18,2,1,17,18,17,17,2,1,2,1,18,1,17,1,18,17,"
        , "17,2,1,17,17,2,17,18,2,18,1,1,17,18,18,1,18,1,2,1,"
        , "2,1,2,18,1,1,17,2,2,2,2,2,18,17,2,17,17,2,1,18,"
        , "1,2,17,2,17,2,18,17,18,2,17,18,17,18,1,1,17,17,2,2,"
        , "18,2,17,18,18,18,18,2,18,18,17,2,18,17,1,2,1,18,2,17,"
        , "17,18,2,1,17,17,17,18,2,17,2,17,17,17,17,17,2,1,1,18,"
        , "1,18,18,18,2,1,2,18,18,18,1,2,17,1,17,2,18,18,18,17,"
        , "2,2,17,18,2,2,17,18,17,2,2,1,1,18,18,2,1,1,2,17,"
        , "2,17,2,2,1,18,17,1,18,2,2,17,1,17,17,18,2,2,1,1");

    TileData data = new TileData();
    data.setValue(csv);
    data.setEncoding(TileData.ENCODING_CSV);
    List<Tile> tiles = data.parseTiles();
    assertEquals(500, tiles.size());
    assertEquals(1, tiles.get(0).getGridId());
    assertEquals(17, tiles.get(19).getGridId());
    assertEquals(18, tiles.get(405).getGridId());
    assertTrue(tiles.get(127).isFlippedHorizontally());
    assertTrue(tiles.get(127).isFlippedVertically());
    assertFalse(tiles.get(127).isFlippedDiagonally());
    assertEquals(18, tiles.get(127).getGridId());
  }
}
