def treeBottom(tree):
    i, j = split(tree)
    
    l = tree[j+1:i+1]
    r = tree[i+2:len(tree)-1]
    
    if l == r == "()":
        return [int(tree[1:j])]
    
    if depth(l) < depth(r):
        return treeBottom(r)
    if depth(l) > depth(r):
        return treeBottom(l)
    
    return treeBottom(l) + treeBottom(r)

    
def depth(tree):
    if tree == "()":
        return 0
    
    i, j = split(tree)
    
    l = tree[j+1:i+1]
    r = tree[i+2:len(tree) - 1]
    
    return 1 + max(depth(l), depth(r))


def split(tree):
    
    x = 0
    y = 0
    
    for j in range(1, len(tree)):
        if not tree[j].isdigit():
            break
    for i in range(j + 1, len(tree)):
        if tree[i] == "(":
            x += 1
        if tree[i] == ")":
            y += 1
        if x == y:
            break
            
    return i, j

