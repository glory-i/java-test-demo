
 #!/bin/sh
 # Wait for PostgreSQL to be available
 set -e
 
 host="$1"
 shift
 cmd="$@"
 
until PGPASSWORD=$POSTGRES_PASSWORD psql -h "$host" -U "dbuser" -d "DBDemoTest" -c '\q'; do
   >&2 echo "PostgreSQL is unavailable - sleeping"
   sleep 1
 done
 
 >&2 echo "PostgreSQL is up - executing command"
 exec $cmd
