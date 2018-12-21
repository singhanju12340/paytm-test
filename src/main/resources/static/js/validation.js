
function Validate() {
        var dbvalue = document.getElementById("database");
        var envvalue = document.getElementById("environment");
        var operationvalue = document.getElementById("operation");

        var queryvalue = document.getElementById("query_text").value;
        var query = queryvalue.trim();

        var query_keyword = query.substr(0, 6);
        if (dbvalue.value == "select") {
            //If the "Please Select" option is selected display error.
            alert("Please select a Database.");
            document.getElementById("database").focus();
            return false;
        }

else if (envvalue.value == "select") {
                    //If the "Please Select" option is selected display error.
                    alert("Please select a Environment.");
                    document.getElementById("environment").focus();
                    return false;
         }

else if (query == null) {
                        //If the "Please Select" option is selected display error.
                        alert("Please Enter your SQL statement.");
                       return false;
                       }
else if (operationvalue.value !== query_keyword) {
                            //If the "Please Select" option is selected display error.
                            alert("Operation is not supported for give SQL statement.");
                            return false;
        }

        return false;
    }


