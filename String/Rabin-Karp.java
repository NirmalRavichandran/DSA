public class RabinKarp{
    private final int PRIME = 101;

    private double calculateHash(String str){
        double hash = 0;
        for(int i=0;i<str.length();i++){
            hash = hash + str.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }

    private double updateHash(double prevHash,char oldChar,char newChar,int patternLength){
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME,patternLength-1);
        return newHash;
    }

    public void Search(String Text,String Pattern){
        int patternLength = Pattern.length();
        double patternHash = calculateHash(Pattern);
        double textHash = calculateHash(Text.substring(0,patternLength));

        for(int i=0;i<=Text.length()-patternLength;i++){
            if(textHash==patternHash){
                if(Text.substring(i,i+patternLength).equals(Pattern)){
                    System.out.println("Pattern found at index "+i);
                }
            }
            if(i<Text.length()-patternLength){
                textHash = updateHash(textHash,Text.charAt(i),Text.charAt(i+patternLength),patternLength);
            }
        }
    }
}
