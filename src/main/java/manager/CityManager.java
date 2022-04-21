package manager;

import dao.City;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public interface CityManager {


    public Set<City> findCityByCountryCodeBetweenPopulation(Connection con, String countryCode, int startLimit, int endLimit) throws SQLException;


}
