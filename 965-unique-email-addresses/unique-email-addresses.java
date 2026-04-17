class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet();
        String domain = "";
        for(int i = 0 ; i < emails.length ; i++){
            String[] spsld = emails[i].split("@");
            if(spsld[0].contains("+"))
                spsld[0] = spsld[0].substring(0,spsld[0].indexOf("+")  );

            if(spsld[0].contains(".")){
                spsld[0] =  spsld[0].replace(".","");
            }
            domain = spsld[0]+"@"+spsld[1];

            if(!hs.contains(domain))
                hs.add(domain);

        }
        return hs.size();
        
    }
}