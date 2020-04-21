package pl.juniorProject.juniorProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JUnitHelper {

    private JUnitHelper (){}

    public static String convertObjectToJson (Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);

    }


}
