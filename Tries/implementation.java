package Tries;

public class implementation {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    public static Node root=new Node();

    public static void insert(String word){// 0(L)
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean search(String key){// 0(L)
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;// agar true hoga to true return kraaga nito false
    }

    public static boolean wordBreak(String key){
        if(key.isEmpty()){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean prefixStartWith(String prefix){
        Node curr=root;

        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }


    // agar hmko unique subString nekalna hai to uska sufix nekalna hai...uska sufix ka prefix nekalo
    // phir usko tries ma daloo...phir jitna numbers of nodes hoga utna  number ka unique subString hoga

    // total number of unique prefix = count of nodes of the tries

    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
//        String word[]={"the","a","there","their","any","thee"};
//        String word[]={"i","like","sam","samsung","mobile","ice"};
//        String key="ilikesamsung";
//        String word[]={"app","apple","mango","man","woman"};
//        String prefix1="app";
//        String prefix2="moon";
//        for(String words:word){
//            insert(words);
//        }
//        System.out.println(search("there"));
//        System.out.println(wordBreak(key));
        String str="ababa";
        // suffix
        for(int i=0;i<str.length();i++){
            String suffix=str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }

}
