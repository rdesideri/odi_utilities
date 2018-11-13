import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.lang.String;
import java.io.File;
   
sourceConnection = odiRef.getJDBCConnection("SRC");
sqlstring = sourceConnection.createStatement();

String query = "INSERT /*+ ignore_row_on_dupkey_index(LIST_FILE_CTRL,PK_LIST_FILE_CTRL) */   INTO LIST_FILE_CTRL(FILE_NAME, SOURCE, TARGET, STATUS, DT_LOAD, DT_LAST_UPDT) VALUES (?,?,?,?,?,?)";

String path = "#PROJETO.StringPath"; 
 
String files;
File folder = new File(path);
File[] listOfFiles = folder.listFiles(); 

for (int i = 0; i < listOfFiles.length; i++) 
{

 if (listOfFiles[i].isFile()) 
 {
    files = listOfFiles[i].getName();
    pstmt = sourceConnection.prepareStatement(query);
    pstmt.setString(1, files); 
    pstmt.setString(2, 'File System');
    pstmt.setString(3, 'File System');
    pstmt.setString(4, 'Waiting');
    pstmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
    pstmt.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
    pstmt.executeUpdate();
   }
}