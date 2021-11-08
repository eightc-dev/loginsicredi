call mvn install:install-file -Dfile=lib/botcity-framework-core-1.0.jar -DgroupId=dev.botcity -DartifactId=botcity-framework-core -Dversion=1.0 -Dpackaging=jar
call mvn install:install-file -Dfile=lib/marvin-framework-2.0.jar -DgroupId=org.marvinproject -DartifactId=MarvinFramework -Dversion=2.0 -Dpackaging=jar
call mvn install:install-file -Dfile=lib/marvin-plugins-2.0.jar -DgroupId=org.marvinproject -DartifactId=MarvinPlugins -Dversion=2.0 -Dpackaging=jar
call mvn clean package