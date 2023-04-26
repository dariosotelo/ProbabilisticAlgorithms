/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probabilisticalgorithms;

/**
 *
 * @author darios
 */
public class SkipList <T extends Comparable <T>> {
    
    private SkipNode<T> head, tail;
    private int count;
    private int level;
    
    public SkipList() {
        this.head=new SkipNode();
        this.tail=new SkipNode();
        this.count=0;
        this.level=0;
    }

    public SkipNode<T> getHead() {
        return head;
    }

    public SkipNode<T> getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }

    public int getLevel() {
        return level;
    }

    public void setHead(SkipNode<T> head) {
        this.head = head;
    }

    public void setTail(SkipNode<T> tail) {
        this.tail = tail;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
    private SkipNode<T> levelSearch(T elem, int level, SkipNode<T> position) {
        if (elem==null)
            return null;
        SkipNode<T> actual = position;
        if (actual.getElem().equals(elem))
            return actual;
        else
            return levelSearch(elem, level, actual.getRight());
    }
    
    //In order to initialize this method, the parameters must be (element to search, top level of the skip list, SkipList.getHead())
    private SkipNode<T> search(T elem, int level, SkipNode<T> position) {
        if (elem==null) 
            return null;
        if (position.getElem().equals(elem))
            //getdown quiere regresar el de abajo
            return position;
        else {
            SkipNode<T> aux=levelSearch(elem, level, position);
            if (aux!=null)
                return aux;
            else
                return search(elem, level-1, position.getDown());
        
        }

    }
    
    public SkipNode<T> search(T elem){
        return search(elem, level, head);
    }
    
    public void delete(T elem) {
        if (elem == null)
            return;
        SkipNode<T> pos = search(elem);
        
        while (pos.getUp()!=null)
            pos=pos.getUp();
            
        pos.getLeft().linkH(pos.getRight());
        
        pos=null;
        
        delete(elem);
        
    }
    
    public void checkCollapse() {
        if (this.getLevel() > Math.floor(Math.log(count))){
            SkipNode<T> aux = head.getDown();
            
            while(aux!=null){
                aux.setUp(null);
                aux=aux.getRight();
            }
            tail=tail.getDown();
            head=head.getDown();
        }
    }
    
    public void newLevel() {
        SkipNode<T> aux1 = new SkipNode();
        SkipNode<T> aux2 = new SkipNode();
        
        aux1.linkH(aux2);
        
        head.linkV(aux1);
        tail.linkV(aux2);
        
        head=aux1;
        tail=aux2;
        level++;
    }
    
    public void insert(T elem) {
        if (search(elem)==null)
            return;
        
        
        
    }
    

    
}
