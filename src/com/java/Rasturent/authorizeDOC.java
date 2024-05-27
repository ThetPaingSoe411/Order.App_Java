package com.java.Rasturent;

import java.io.*;

public class authorizeDOC {
    private File file;

    public authorizeDOC(){
        file = new File("C:\\Users\\User\\IdeaProjects\\Rasturent.App\\src\\Autho\\autho.txt");
    }

   public void addAuthorize(Authorize authorize){
        MyArray authorizes = loadAllDataToAuthorize();
        authorizes.add(authorize);
        writeDataToAuthorizeFile(authorizes);
   }
   public MyArray displayAuthorize(){
        return loadAllDataToAuthorize();
   }

    private void writeDataToAuthorizeFile(MyArray authorizes){
        try(
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                ){
            if(!authorizes.isEmpty()){
                for(int i=0;i<authorizes.getOrderCount();i++){
                    Authorize authorize = (Authorize) authorizes.get(i);
                    writer.write(authorize.displayAuthorize());
                    writer.write("\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MyArray loadAllDataToAuthorize(){
        MyArray authorizes = new MyArray(50);
        try(
                BufferedReader reader = new BufferedReader(new FileReader(file))
                ){
          String line;
          while((line = reader.readLine()) != null){
              String[] datas = line.split(" ");
              int id = Integer.parseInt(datas[0]);
              String name = datas[1];
              String email = datas[2];
              String password = datas[3];
              String confirmPassword = datas[4];
              authorizes.add(new Authorize(id,name,email,password,confirmPassword));
          }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return authorizes;
    }






}
