package dao;

import lombok.*;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class City {
    private  int id;
    private String name;
    private String CountryCode;
    private String District;
    private BigInteger population;


    public City(ResultSet result) throws SQLException {
        setId(result.getInt("Id"));
        setName(result.getString("name"));
        setCountryCode(result.getString("CountryCode"));
        setDistrict(result.getString("District"));
        setPopulation(result.getBigDecimal("Population").toBigInteger());
    }
}
