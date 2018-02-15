import static spark.Spark.*;//imports the Spark framework necessary to run the local server

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");//defines the default location where the server should look for requested files
        get("/", ((request, response) -> {//defines default route for initial GET from client
            response.redirect("/index.html");//sends index.html to client
            return null;//required return statement
        }));
        get("/people", ((request, response) -> {//defines route for a GET command from client to the /people directory
            response.type("application/json");//defines type of information in the return statement below
            return "{\n" +//information sent back to client; this specific info is in JSON format.
                    "  \"people\" : [\n" +
                    "    {\n" +
                    "      \"name\" : \"Scott\",\n" +
                    "      \"city\" : \"Phoenix\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Koddie\",\n" +
                    "      \"city\" : \"Huxley\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Mark\",\n" +
                    "      \"city\" : \"Cooperstown\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Ted\",\n" +
                    "      \"city\" : \"Chicago\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Joan\",\n" +
                    "      \"city\" : \"Chicago\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Lori\",\n" +
                    "      \"city\" : \"Maramar\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Manny\",\n" +
                    "      \"city\" : \"Santa Ana\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Zech\",\n" +
                    "      \"city\" : \"Whitmore\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Kym\",\n" +
                    "      \"city\" : \"Kailua-Kona\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\" : \"Jake\",\n" +
                    "      \"city\" : \"Saratoga Springs\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";
        }));
    }
}