package com.customerservice.customerservice.dto.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OpenStreetMapResponse {

    private Address address;

    @JsonProperty("addresstype")
    private String addressType;

    @JsonProperty("boundingbox")
    private List<String> boundingBox;

    private String category;

    @JsonProperty("display_name")
    private String displayName;

    private double importance;

    private String lat;

    private String lon;

    private String name;

    @JsonProperty("osm_id")
    private Long osmId;

    @JsonProperty("osm_type")
    private String osmType;

    @JsonProperty("place_id")
    private Long placeId;

    @JsonProperty("place_rank")
    private int placeRank;

    private String type;

    @Data
    public static class Address {

        @JsonProperty("ISO3166-2-lvl4")
        private String iso3166_2_lvl4;

        private String borough;

        private String city;

        private String country;

        @JsonProperty("country_code")
        private String countryCode;

        private String neighbourhood;

        private String postcode;

        private String road;

        private String shop;

        private String suburb;
    }
}