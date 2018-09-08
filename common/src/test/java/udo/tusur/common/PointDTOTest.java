package udo.tusur.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointDTOTest {
    private long time = System.currentTimeMillis();

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":" + time + "}";

    private PointDTO point = new PointDTO(56, 74, "o567gfd", time);

    @Test
    public void toJson() throws Exception {
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"+ time));
        assertTrue(point.toJson().contains("\"lon\":74.0"));
        assertTrue(point.toJson().contains("\"autoId\":\"o567gfd\""));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDto() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO point = mapper.readValue(expected, PointDTO.class);
        assertEquals("o567gfd", point.getAutoId());
        assertEquals(time, point.getTime());
        assertEquals(56.0, point.getLat(), 0.001);
        assertEquals(74.0, point.getLon(), 0.001);
    }
}
