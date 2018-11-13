import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.lang.String;
import java.io.File;
import java.sql.Blob; 
import java.sql.ResultSet; 
   
connection = odiRef.getJDBCConnection("SRC");
statement = connection.createStatement();
rs = statement.executeQuery("select file_name, blob_field from tb_file where file_name = '#PROJECT.FileName'");

if (rs.next()) {

    String filename = rs.getString(1);
    Blob blob = rs.getBlob(2);
    InputStream is = blob.getBinaryStream();
    FileOutputStream fos = new FileOutputStream("#PROJECT.FileDestination" + filename);

    int b = 0;
    while ((b = is.read()) != -1)
    {
        fos.write(b); 
    }
}