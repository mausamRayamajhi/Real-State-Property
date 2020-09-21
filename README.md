# Real-State-Property
Assignment Two (Group Assignment)


asadmin create-jdbc-connection-pool --datasourceclassname=org.apache.derby.jdbc.ClientDataSource --restype=javax.sql.DataSource --property portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=realstatedb:connectionAttributes=;create\=true realstatePool


asadmin ping-connection-pool realstatePool


asadmin create-jdbc-resource --connectionpoolid realstatePool jdbc/realstatedb


# Git command

git status

git add .

git commit -m "Message"

git pull

git push