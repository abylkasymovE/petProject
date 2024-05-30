package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CustomResponse {

    private String category_title;
    private int category_id;
    private String category_description;
    private String created;

    private int seller_id;
    private String seller_name;
    private String company_name;



}
