package com.example;

public class encryptlord {
    private String[] parts = new String[4];
    private String[] binaryparts = new String[4];

    public encryptlord(String input) {
        StringBuilder pswd = new StringBuilder(input);
        if(pswd.length() % 2 == 1){
            pswd.append("a");
        }
        this.parts[0] = pswd.substring(0, ((pswd.length() / 2) / 2));
        this.parts[1] = pswd.substring(((pswd.length() / 2) / 2), (pswd.length()/2));
        this.parts[2] = pswd.substring((pswd.length()/2), ((pswd.length()/2)+(pswd.length() / 2) / 2));
        this.parts[3] = pswd.substring(((pswd.length()/2)+(pswd.length() / 2) / 2));
    }
    public void turntobinary() {
        
        int count = 0;
        for(String w:parts){
            StringBuilder ready = new StringBuilder();
            for(int c: w.toCharArray()){
                try{
                    String binary = String.format("%8s",Integer.toBinaryString(c)).replace(' ', '0');
                ready.append(binary);
                } catch (Exception error) {
                    error.printStackTrace();
                }
                
            }
            binaryparts[count] = ready.toString();
            count++;
        }
    }
    public String getparts(int part){
        if(part >= 0 && part < binaryparts.length) {
            return binaryparts[part];
        }
            return binaryparts[0];
        }
    

    public String runthrough(String input, int choice){
        StringBuilder output = new StringBuilder();
        for(int i =0; i < input.length() - 1; i++) {
            switch(choice) {
                case 1:
                if((input.charAt(i) == '1') && (input.charAt(i + 1) =='1')) {
                    output.append('1');
                } else { output.append('0');}
                break;

                case 2:
                if((input.charAt(i) == '1') || input.charAt(i + 1) == '1') {
                     output.append("1");
                } else { output.append("0");}
                break;

                case 3:
                if((input.charAt(i) == '1') ^ (input.charAt(i + 1) =='1')) {
                    output.append('1');
                } else { output.append('0');}
                break;

                case 4:
                if(!((input.charAt(i) == '1') ^ input.charAt(i + 1) == '1')) {
                     output.append("1");
                } else { output.append("0");}
                break;
            }
        }
        output.append(input.charAt(input.length() - 1));
        return output.toString();
    }
    public void pswdcycler(){
        for(int i = 0; i <4; i++){
            binaryparts[i] = runthrough(getparts(i), i + 1);
        }
    }
}
