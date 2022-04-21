package conector;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Set;

import dao.City;
import  lombok.Setter;
import  lombok.Getter;
import manager.CityManagerImplemts;

public class MysqlConector {
    @Setter
    @Getter
    Properties prop = new Properties();

    public MysqlConector(){
        try{
            prop.load(getClass().getClassLoader().getResourceAsStream("config.propeties"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Creates the connection object for a MySQL DDBB
     * @return a {@link Connection}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getMysqlConector() throws ClassNotFoundException, SQLException {
        try {

            //Indicates which driver is going to be used.
            Class.forName(prop.getProperty(MysqlConstant.DRIVER));
            //Creates the connection based on the obtained URL.
            return  DriverManager.getConnection(getURL());
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }



    /**
     * Obtains the URL to connect to a MySQL DDBB.
     * @return an URL
     */
    private String getURL() {
        //jdbc:mysql://localhost:3306/world?user=sa&password=12345678&useSSL=false;
        return new StringBuilder().append(prop.getProperty(MysqlConstant.URL_PREFIX))
                .append(prop.getProperty(MysqlConstant.URL_HOST)).append(":")
                .append(prop.getProperty(MysqlConstant.URL_PORT)).append("/")
                .append(prop.getProperty(MysqlConstant.URL_SCHEMA)).append("?user=")
                .append(prop.getProperty(MysqlConstant.USER)).append("&password=")
                .append(prop.getProperty(MysqlConstant.PASSWD)).append("&useSSL=")
                .append(prop.getProperty(MysqlConstant.URL_SSL))
                .append(("&useJDBCCompliantTimezoneShift="))
                .append(prop.getProperty(MysqlConstant.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT)).append(("&useLegacyDatetimeCode="))
                .append(prop.getProperty(MysqlConstant.USE_LEGACY_DATE_TIME_CODE)).append(("&serverTimezone="))
                .append(prop.getProperty(MysqlConstant.SERVER_TIMEZONE)).toString();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            MysqlConector Conector = new MysqlConector();
            ejemploStatement();



    }

    private static void ejemploStatement() throws SQLException, ClassNotFoundException {
        MysqlConector connector = new MysqlConector();
        try(Connection connection = connector.getMysqlConector();
            Statement stm = connection.createStatement()) {

            ResultSet result = stm.executeQuery("SELECT Id, Name, District FROM world.city where CountryCode = 'ESP'");
            int counter = 0;
            result.beforeFirst();
            while (result.next()) {
                int id = result.getInt("Id");
                String name = result.getString("Name");
                String district = result.getString("District");
                System.out.println(id + " " + name + " " + district);
                counter++;
            }
            System.out.println("Total de elementos: " + counter);
        }
    }

    private static void ejemploPreparedStatement() throws SQLException, ClassNotFoundException {
        Connection connection = new MysqlConector().getMysqlConector();
        CityManagerImplemts cityManager = new CityManagerImplemts();
        Set<City> cities = cityManager.findCityByCountryCodeBetweenPopulation(connection, "ESP", 100000, 250000);
        System.out.println(cities);
        System.out.println("Total de elementos: " + cities.size());
    }


}
