package udo.tusur.servercore;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import udo.tusur.common.PointDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DependencyTest {
    private String expected = "{\"lat\":12.0,\"lon\":32.0,\"autoId\":\"df123f\",\"time\":1489900897458}";

    @Test
    public void toJSON() throws Exception {
        PointDTO point = new PointDTO(12, 32, "df123f", System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":12"));

    }

    @Test
    public void fromJSON() throws Exception  {
        ObjectMapper mapper = new ObjectMapper();
        assertEquals("df123f", mapper.readValue(expected, PointDTO.class).getAutoId());

    }

}
