import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
     
	 
public class HeaderCompare {

    public static void main(String[] args) throws IOException 
    {
        String PathHeader = "#PROJETO.PathHeader";
        String PathNewFile = "#PROJETO.PathNewFile";
        
        BufferedReader br = new BufferedReader(new FileReader(PathNewFile));
        String linha = br.readLine();
	
        File file = new File(PathHeader);
        if(file.exists()){
            BufferedReader brHeader = new BufferedReader(new FileReader(PathHeader));
            String linhaHeader = brHeader.readLine();
            if(linhaHeader.equals(linha))
            {
                System.out.println("Header OK");
            }
            else
            {
                System.out.println("Header esperado: " + linhaHeader + "\n");
                System.out.println("Header recebido: " + linha);
            }
            
        }else{
            new File(PathHeader).createNewFile();
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PathHeader));
            buffWrite.append(linha);
            buffWrite.close();     
        }
	br.close();	
    }
    
}
