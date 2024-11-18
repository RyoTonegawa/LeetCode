import java.util.Stack;

public class SimplifyPath{
  public String Solution(
    String path
  ){ 
    /**
     * handle edge case
     */
    if(
      path == null ||
      path.isEmpty()
    ){
      return "/";
    }
    /**
     * variable declaration
     * `stack` is used to process the 
     * path components
     * `components` is used to store
     * each directory name after
     * splitting the path. 
     */
     Stack<String> stack = new Stack<>();
     String[] components = path.split("/");
    /**
     * Iterate through the components
     */
     for(
      String component:components
     ){
        if(
          component.equals("")||
          component.equals(".")
        ){
          //Ignore empty strings and single
          //periods
          /**
           * Because single period represents
           * the current directory at the 
           * beginning of the path.
           * And empty component means
           * a series of slashes are included
           * in the path.
           * This series of the path is 
           * treated as a one slash. 
           */
          continue;
        }else if(
          component.equals("..")
        ){
          /**
           * In the Unix path rule,
           * ".." means go up one directory.
           * So, delete one stack component.
           * The 'pop' operation simulates
           * moving back to the parent
           * directory
           */
          if(!stack.isEmpty()){
            stack.pop();
          }
        }else{
          /**
           * Other components represent 
           * normal directories or 
           * normal file paths
           */
          stack.push(component);
        }
     }
     /**
      * Finally, declare a StringBuilder
        and connect each component 
      */
     StringBuilder simplifiedPath = new StringBuilder();
     for(String dir:stack){
      simplifiedPath.append("/").append(dir);
     };
     return simplifiedPath.length()> 0 ? simplifiedPath.toString():"/";
  }
}