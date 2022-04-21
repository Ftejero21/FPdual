package manager;

import dao.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CityManagerImplemts implements CityManager{

    @Override
    public Set<City> findCityByCountryCodeBetweenPopulation(Connection con, String countryCode, int startLimit, int endLimit) throws SQLException {
        Set<City> citySet = null;
        try (PreparedStatement prepstm = con.prepareStatement("SELECT * FROM world.city " +
                "where CountryCode = ? AND Population BETWEEN ? AND ?")) {

            prepstm.setString(1, countryCode);
            prepstm.setInt(2, startLimit);
            prepstm.setInt(3, endLimit);

            ResultSet result = prepstm.executeQuery();

            citySet = new HashSet<>();
            ((ResultSet) result).beforeFirst();
            while (result.next()) {
                City city = new City(result);
                citySet.add(city);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return citySet;
    }
}
