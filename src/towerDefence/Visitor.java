package towerDefence;

public interface Visitor {
	
	public void visit(Knight k);
	public void visit(Skeleton s);
	public void visit(Mike m);
	public void visit(Naji n);

}
