FROM mcr.microsoft.com/mssql/server:2019-latest

USER root

# Install curl + Microsoft repo + SQLCMD tools
RUN apt-get update && apt-get install -y curl gnupg2 && \
    curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add - && \
    curl https://packages.microsoft.com/config/debian/10/prod.list > /etc/apt/sources.list.d/mssql-release.list && \
    apt-get update && ACCEPT_EULA=Y apt-get install -y \
        msodbcsql17 \
        mssql-tools \
        unixodbc-dev && \
    echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc

ENV PATH=$PATH:/opt/mssql-tools/bin
