
 #!/bin/bash
 # entrypoint.sh - Custom startup script for initializing MSSQL container
 
 # Start SQL Server in the background
 /opt/mssql/bin/sqlservr &
 
 # Wait for SQL Server to fully start.
 echo "Waiting for SQL Server to start..."
 # A simple sleep can work, but for production consider a loop checking connectivity.
 sleep 30
 
 # Run your initialization SQL script (init.sql must exist in the same mounted directory).
 echo "Running initialization script..."
 /opt/mssql-tools/bin/sqlcmd -S localhost -U dbuser -P StrongDBPass123456789* -i /docker-entrypoint-initdb.d/Database.sql
 
 # Wait for SQL Server process to exit (keeps the container running).
 wait
