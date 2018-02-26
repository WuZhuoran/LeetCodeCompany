public class Solution {

  public static class Node {
    boolean isWord;
    Map<Byte, Node> children = new HashMap<Byte, Node>();
  }

  public static class Trie {
    Node root = new Node();

    void add(String str) {
      Node node = root;
      for(int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        node = node.children.computeIfAbsent((byte)ch, s->new Node());
      }
      node.isWord = true;
    }

    static String preparePattern(String pattern) {
      return pattern.replaceAll("\\*+", "*");
    }

    String stringFromPath(List<String> path) {
      return String.join("", path);
    }

    void search(Node node, String pattern, int pos, LinkedList<String> path, Set<String> found) {
      if(pos == pattern.length()) {
        if(node.isWord) {
          found.add(stringFromPath(path));
          return;
        }
      }

      char ch = pattern.charAt(pos);

      if(ch == "*") {
        if(pos == pattern.length() - 1 && node.isWord) {
          found.add(stringFromPath(path));
          if(node.children.size() == 0) {
            return;
          }
        }

        for(Map.Entry<Byte, Node> entry : node.children.entrySet()) {
          Node nextNode = entry.getValue();
          path.addLast(String,valueOf((char)(entry.getKey().byteValue())));
          search(nextNode, pattern, pos, path, found);
          search(nextNode, pattern, pos+1, path, found);
          path.removeLast();
        }
      } else {
        Node nextNode = node.children.get((byte)ch);
        if(nextNode != null) {
          path.addLast(String.valueOf(ch));
          search(nextNode, pattern, pos+1, path, found);
          path.removeLast();
        }
      }
    }

    Set<String> searchPattern(String pattern) {
      pattern = preparePattern(pattern);

      Set<String> found = new HashSet<String>();
      search(root, pattern, 0, new LinkedList<String>(), found);

      return found;
    }

  }





}
