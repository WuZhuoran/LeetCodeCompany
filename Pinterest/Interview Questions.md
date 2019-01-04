# 面经


1. Minimum Window Substring

要求在源字符串s中找到长度最短的子串，这个子串包含目标字符串t中的所有字符，字符顺序没有要求。

注意在找到的子串中可以包含t中没有的字符。

乍一看是滑动窗的问题，如果题目要求是”在s中找到子串t，t中字符顺序无要求”，那么只需要维护一个长度为t的大小的滑动窗遍历s即可，这种做法要求找到的子串长度就是t的长度，且无其他t中没有的字符。

但是难点在本题可以存在t中没有的字符，比如示例中找到的子串是”BANC”，其中”BAC”是t，而’N’不属于t。所以，滑动窗的大小是需要动态变化的。

根据滑动窗的概念，解决问题时需要两个指针begin和end分别指向窗口的左边界和右边界，在向右移动的过程中右边加，左边减，直到满足条件即可。

但是，由于本题的滑动窗大小不固定，所以在向右移动的过程中，只能右边加，而不能左边减。只有当窗口此时覆盖的区域包含t时，才执行左边减。

不过，对于右边加左边减，仍然不是简单的将左边的字符删掉，将右边的字符添加进来。

考虑本题，题目中要求找到最短的窗口，这个窗口拥有t中所有的字符。同时根据end的增长，可以确定当窗口覆盖的区域包含t中所有字符以进行左边减时，end指向的字符一定在t中。

但是，没有办法确定begin指向的字符是否在t中，换句话说，程序一开始只是end在移动，当确定窗口中包含t中所有字符后开始执行左边减。但是begin的那个位置就没有动过，不一定就是t中的字符。

所以，在将左边界指向的字符删除后，如果当前的窗口仍然包含t中所有字符，那么可以继续将左边界删掉，直到窗口中缺少t中的某个字符时，在进行向右移动。

算法的难点就在于，如果确定当前窗口包含t中所有字符，由如何确定当前窗口缺少了t中的某个字符，这个字符是什么。

首先，定义一个容器，这个容器记录着当前滑动窗缺少t中哪几个字符，每个字符缺少多少个。这个容器可以是map，也可以是vector，这里定义成

vector<int> map(128, 0);
1
对于这个容器，规定

对于字符ch，map[ch]表示的是当前滑动窗缺少几个ch
如果map[ch]大于0，说明缺少map[ch]个ch
如果map[ch]小于0，说明滑动窗中富余|map[ch]|个ch(map[ch]的绝对值个)
如果map[ch]等于0，说明滑动窗中不缺少字符ch，也不富余字符ch
对于这个容器的操作，规定

通过end遍历到的字符ch，因为是将end遍历到的字符添加到滑动窗中，所以执行map[ch]–，即代表加进来一个ch，那么对于ch的缺少数量就应该减一
通过begin遍历到的字符ch，因为是将begin遍历到的字符从滑动窗中删除，所以执行map[ch]++，即代表删掉一个ch，那么对于ch的缺少数量就应该加一
根据这个定义，初始化时将目标字符串t中所以字符放到这个容器中，代表缺少t中所有的字符，即

for(auto ch : t)
    ++map[ch];
1
2
不过，注意上述对于容器map的操作规定没有涉及字符ch是否是目标字符串t中的字符，也就是说在规则中的ch不一定属于t。这不要紧，因为根据定义，遍历到的字符ch会执行map[ch]–，那么如果ch不在t中，说明执行后map[ch]小于0，根据小于0的定义，是说明滑动窗中富余|map[ch]|个ch。富余没关系，关键是不能缺少。

那么什么时候代表滑动窗中包含了t中所有元素呢，需要定义一个计数器，这个计数器记录着当前滑动窗口缺少t中多少个字符。可以用一个int类型的变量，初始时是t的总大小。

那么什么时候更新这个计数器呢，需要根据begin和end遍历到的字符进行适当更新

适当更新的含义是，有时候更新，有时候不更新0.0

其实是这样:)

如果通过end添加进滑动窗的字符是容器缺少的那个（由上面定义可知缺少的字符一定都是t中的字符），那么计数器减一。怎么判断是不是容器缺少的呢，可以判断map[s[end]]是否大于0
如果通过begin删掉的字符刚好是容器中既不缺少的字符，也不是富余的字符（由上面定义可知这些字符也一定都是t中的字符），那么计数器加一。同理判断依据是map[s[end]]是否等于0
另外需要注意，在进行左边减的过程中（即已经确定滑动窗中包含t中所有字符），需要不断记录最短的滑动窗的位置

代码如下

```c++
class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> map(128, 0);
        for(auto ch : t)
            ++map[ch];
        int counter = t.size();
        int begin = 0, end = 0;
        int head = 0;
        int len = INT_MAX;
        while(end < s.size())
        {
            // 右边加，当这个字符是滑动窗缺少的字符时，计数器减一
            if(map[s[end++]]-- > 0) --counter;
            while(counter == 0)
            {
                if(end - begin < len)
                {
                    len = end - begin;
                    head = begin;
                }
                // 左边减，当这个字符是滑动窗不缺也不富余的字符时，计数器加一
                if(map[s[begin++]]++ == 0)  ++counter;
            }
        }
        return len == INT_MAX ? "" : s.substr(head, len);
    }
};
```

```java
public class Solution {
public String minWindow(String s, String t) {
    if(s == null || s.length() < t.length() || s.length() == 0){
        return "";
    }
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    for(char c : t.toCharArray()){
        if(map.containsKey(c)){
            map.put(c,map.get(c)+1);
        }else{
            map.put(c,1);
        }
    }
    int left = 0;
    int minLeft = 0;
    int minLen = s.length()+1;
    int count = 0;
    for(int right = 0; right < s.length(); right++){
        if(map.containsKey(s.charAt(right))){
            map.put(s.charAt(right),map.get(s.charAt(right))-1);
            if(map.get(s.charAt(right)) >= 0){
                count ++;
            }
            while(count == t.length()){
                if(right-left+1 < minLen){
                    minLeft = left;
                    minLen = right-left+1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) > 0){
                        count --;
                    }
                }
                left ++ ;
            }
        }
    }
    if(minLen>s.length())
    {
        return "";
    }

    return s.substring(minLeft,minLeft+minLen);
}
}
```

2. 一个二维的board,里面有0（表示可以通过），1（wall不能通过），6（monster，可以通过但是会丢一条命）。input是start position, end position 和lives(有多少命)。问start到end的最短距离

```dfs
int DFS_Search(int i, int j)
{

    isUsed[i][j] = 1;    
    if ( map[i][j] == 'G' )
    {
        return 0;
    }
    else
    {
        int MinDistance = 9999;
        if ( i - 1 >= 0 && map[i-1][j] != '#' && isUsed[i-1][j] == 0)
        {
            int dis = DFS_Search(i-1, j) + 1;
            MinDistance = dis < MinDistance ? dis : MinDistance;
        }
        if ( i + 1 <= N - 1 && map[i+1][j] != '#' && isUsed[i+1][j] == 0)
        {
            int dis = DFS_Search(i+1, j) + 1;
            MinDistance = dis < MinDistance ? dis : MinDistance;
        }
        if ( j - 1 >= 0 && map[i][j-1] != '#' && isUsed[i][j-1] == 0)
        {
            int dis = DFS_Search(i, j-1) + 1;
            MinDistance = dis < MinDistance ? dis : MinDistance;
        }
        if ( j + 1 <= M - 1 && map[i][j+1] != '#' && isUsed[i][j+1] == 0)
        {
            int dis = DFS_Search(i, j+1) + 1;
            MinDistance = dis < MinDistance ? dis : MinDistance;
        }
        return MinDistance;
    }
}
```


3. alien dictionary

图的深度优先搜索。深度优先的关键点在于如何检查环路，使用visited=0/1/2而不是布尔类型可以解决，即visited=0表示未访问UNVISITED，1表示访问中VISITING，2表示已访问VISITED。另外，深度优先搜索的话，graph用入边来表示，graph[i][j] = true <=> j->i，这样就容易通过递归方式，先解决所依赖的节点。

```java
public class Solution {
    private void find(boolean[] alphabets, boolean[][] graph, int tail, int[] visited, StringBuilder sb) {
        if (!alphabets[tail] || visited[tail] != 0) return;
        visited[tail] = 1;
        for(int i=0; i<graph[tail].length; i++) {
            if (graph[tail][i] && alphabets[i] && visited[i] == 1) return;
            if (graph[tail][i] && alphabets[i] && visited[i] == 0) find(alphabets, graph, i, visited, sb);
        }
        visited[tail] = 2;
        sb.append((char)(tail+'a'));
    }
    public String alienOrder(String[] words) {
        char[][] ws = new char[words.length][];
        boolean[] alphabets = new boolean[26];
        int letters = 0;
        for(int i=0; i<words.length; i++) {
            ws[i] = words[i].toCharArray();
            for(int j=0; j<ws[i].length; j++) {
                if (!alphabets[ws[i][j]-'a']) {
                    alphabets[ws[i][j]-'a'] = true;
                    letters ++;
                }
            }
        }
        boolean[][] graph = new boolean[26][26];
        for(int i=0; i<words.length-1; i++) {
            for(int j=0; j<Math.min(words[i].length(), words[i+1].length()); j++) {
                if (ws[i+1][j] != ws[i][j]) {
                    graph[ws[i+1][j]-'a'][ws[i][j]-'a'] = true;
                    break;
                }
            }
        }
        int[] visited = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<alphabets.length; i++) {
            if (!alphabets[i] || visited[i]!=0) continue;
            find(alphabets, graph, i, visited, sb);
        }
        // System.out.println(sb.toString());
        if (sb.length() == letters) return sb.toString(); else return "";
    }
}
```


4. blacklist
有一个blacklist，比如{"porn","world war I"}. 找出所有含有黑名单里句子的句子。input是List of sentence 碧如:{"I love porn", "I love world war II"}. 那么"I love porn"含有"porn"，就被找出来。"world war II"就不对，因为blacklist里面是"world war I". 要求是word level的

```java
// Trie Tree

class Node {
    char content; // the character in the node
    boolean isEnd; // whether the end of the words
    int count;  // the number of words sharing this character
    LinkedList<Node> childList; // the child list

    public Node(char c){
        childList = new LinkedList<Node>();
        isEnd = false;
        content = c;
        count = 0;
    }

    public Node subNode(char c){
        if(childList != null){
	        for(Node eachChild : childList){
	            if(eachChild.content == c){
	                 return eachChild;
	            }
        	}
        }
        return null;
   }
}

public class Trie{
    private Node root;

    public Trie(){
        root = new Node(' ');
    }

    public void insert(String word){
    	if(search(word) == true) return;

        Node current = root;
        for(int i = 0; i < word.length(); i++){
            Node child = current.subNode(word.charAt(i));
            if(child != null){
                current = child;
            } else {
                 current.childList.add(new Node(word.charAt(i)));
                 current = current.subNode(word.charAt(i));
            }
            current.count++;
        }
        // Set isEnd to indicate end of the word
        current.isEnd = true;
    }
    public boolean search(String word){
	    Node current = root;

	    for(int i = 0; i < word.length(); i++){    
            if(current.subNode(word.charAt(i)) == null)
                return false;
            else
                current = current.subNode(word.charAt(i));
        }
        /*
        * This means that a string exists, but make sure its
        * a word by checking its 'isEnd' flag
        */
        if (current.isEnd == true) return true;
        else return false;
    }

    public void deleteWord(String word){
		if(search(word) == false) return;

		Node current = root;
		for(char c : word.toCharArray()) {
			Node child = current.subNode(c);
			if(child.count == 1) {
				current.childList.remove(child);
				return;
			} else {
				child.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("ball");
		trie.insert("balls");
		trie.insert("sense");

		// testing deletion
		System.out.println(trie.search("balls"));
		System.out.println(trie.search("ba"));
		trie.deleteWord("balls");
		System.out.println(trie.search("balls"));
		System.out.println(trie.search("ball"));
	}
}

```

5. 给一个unsorted 数组：[1, 2, 5, 10, 11]和一个target：10. 找出target在sorted pairwise里面排第几
该数组的soreted pairwise 是：1+1, 1+2, 2+2, 1+5, 2+5, 5+5, 1+10.....那么就返回6

6. meeting room 2 变种，每个interval有weight，overlap的部分，weight相加

```java
class Solution {
    public int minMeetingRooms(Interval[] intervals) {

        if(intervals == null || intervals.length < 1) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.end - v2.end;
            }
        });

        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();

            if(interval.end > intervals[i].start) {
                // need a new room
                pq.offer(intervals[i]);
            } else {
                // do not need a new room
                interval.end = intervals[i].end;
            }

            pq.offer(interval);
        }

        return pq.size();
    }
}
```

7. string的问题，一个很长的string T，只有（A-Z)， 然后很多query（eg. ADD)，然后问T中是否能够找出包含query的substring，中间可以隔着一些字母，比如ABCDED是一个合格的case。我给了个dict的算法，然后又问了优化

8. Find median from Data Stream

```java
class MedianFinder {

    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());

    public MedianFinder() {

    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double)(maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }
};
```


9. 给一些pair, 代表(employee, manager), 然后按照organizaition的结构打印。比如[2, 1],[1, 0], [3, 0], [0, 0], 0是自己的manager, 就代表他是CEO，输出是：
```
0
|_1
    |_2
|_3
```
在parse每个pair的过程中就可以同时知道哪个是CEO（即indegree为0的点）。Parse pair的过程就是建立graph，可以用adjacency-list 来表示这个graph。然后从CEO这个点做BFS就可以了。如果这些pair里包括跨级的关系，需用topological sort来最终打印关系表。

10. ML optimizer

* SGD
$$
g_t=\nabla_{\theta_{t-1}}{f(\theta_{t-1})} \\

\Delta{\theta_t}=-\eta*g_t
$$

* Momentum

下降初期时，使用上一次参数更新，下降方向一致，乘上较大的$\mu$能够进行很好的加速

下降中后期时，在局部最小值来回震荡的时候，$gradient\to0$，$\mu$使得更新幅度增大，跳出陷阱

在梯度改变方向的时候，$\mu$能够减少更新 总而言之，momentum项能够在相关方向加速SGD，抑制振荡，从而加快收敛

$$
m_t=\mu*m_{t-1}+g_t \\

\Delta{\theta_t}=-\eta*m_t
$$

* Nesterov

nesterov项在梯度更新时做一个校正，避免前进太快，同时提高灵敏度。
所以Nesterov的改进就是让之前的动量直接影响当前的动量。

$$
\Delta{\theta_t}=-\eta*\mu*m_{t-1}-\eta*g_t
$$

* Adagrad

Adagrad其实是对学习率进行了一个约束

前期$g_t$较小的时候， regularizer较大，能够放大梯度

后期$g_t$较大的时候，regularizer较小，能够约束梯度

适合处理稀疏梯度

$$
n_t=n_{t-1}+g_t^2 \\

\Delta{\theta_t}=-\frac{\eta}{\sqrt{n_t+\epsilon}} * g_t

$$

* Adadelta

Adadelta是对Adagrad的扩展，最初方案依然是对学习率进行自适应约束，但是进行了计算上的简化。 Adagrad会累加之前所有的梯度平方，而Adadelta只累加固定大小的项，并且也不直接存储这些项，仅仅是近似计算对应的平均值。

训练初中期，加速效果不错，很快

训练后期，反复在局部最小值附近抖动


$$
n_t=\nu*n_{t-1}+(1-\nu) * g_t^2 \\

\Delta{\theta_t} = -\frac{\eta}{\sqrt{n_t+\epsilon}} * g_t
$$

* RMSprop

RMSprop可以算作Adadelta的一个特例：

其实RMSprop依然依赖于全局学习率

RMSprop算是Adagrad的一种发展，和Adadelta的变体，效果趋于二者之间
适合处理非平稳目标 - 对于RNN效果很好

$$
\Delta{x_t}=-\frac{\eta}{RMS|g|t} * g_t
$$

* Adam

Adam(Adaptive Moment Estimation)本质上是带有动量项的RMSprop，它利用梯度的一阶矩估计和二阶矩估计动态调整每个参数的学习率。Adam的优点主要在于经过偏置校正后，每一次迭代学习率都有个确定范围，使得参数比较平稳。

结合了Adagrad善于处理稀疏梯度和RMSprop善于处理非平稳目标的优点

对内存需求较小

为不同的参数计算不同的自适应学习率

也适用于大多非凸优化 - 适用于大数据集和高维空间

$$
m_t=\mu*m_{t-1}+(1-\mu) * g_t \\

n_t=\nu*n_{t-1}+(1-\nu) * g_t^2 \\

\hat{m_t}=\frac{m_t}{1-\mu^t} \\

\hat{n_t}=\frac{n_t}{1-\nu^t} \\

\Delta{\theta_t}=-\frac{\hat{m_t}}{\sqrt{\hat{n_t}}+\epsilon} * \eta
$$
