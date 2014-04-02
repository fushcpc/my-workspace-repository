#print 'Setting up the generic JVM arguments'
#AdminTask.setJVMProperties('[-serverName server1 -nodeName Jimmy-PCNode02 -genericJvmArguments "-Xquickstart -Duser.language=en -Duser.region=US"]');
#print 'JVM arguments done'
#
#print 'Create Oracle JDBC driver path'
#AdminConfig.create('VariableSubstitutionEntry', '(cells/Jimmy-PCNode02Cell/nodes/Jimmy-PCNode02/servers/server1|variables.xml#VariableMap_1)', '[[symbolicName "ORACLE_JDBC_DRIVER_PATH"] [description "ORACLE_JDBC_DRIVER_PATH"] [value "D:\DevTools\JDBC\oracle"]]')
#print 'Oracle JDBC driver path property done'
#
#print 'Creating Oracle JDBC provider'
#AdminTask.createJDBCProvider('[-scope Node=Jimmy-PCNode02,Server=server1 -databaseType Oracle -providerType "Oracle JDBC Driver" -implementationType "XA data source" -name "Oracle JDBC Driver (XA)" -description "Oracle JDBC Driver (XA)" -classpath [${ORACLE_JDBC_DRIVER_PATH}/ojdbc6.jar ] -nativePath "" ]')
#print 'Oracle JDBC provider done'
#
print 'Creating TitanDataSource'
AdminTask.createDatasource('"Oracle JDBC Driver (XA)(cells/Jimmy-PCNode02Cell/nodes/Jimmy-PCNode02/servers/server1|resources.xml#JDBCProvider_1386083443790)"', '[-name TitanDataSource -jndiName jdbc/TitanDataSource -dataStoreHelperClassName com.ibm.websphere.rsadapter.Oracle11gDataStoreHelper -containerManagedPersistence true -componentManagedAuthenticationAlias -xaRecoveryAuthAlias -configureResourceProperties [[URL java.lang.String jdbc:oracle:thin:@localhost:1521:orcl]]]')
print 'TitanDataSource created'

AdminConfig.save();
print 'Jobs done'