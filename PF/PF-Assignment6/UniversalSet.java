public interface UniversalSet {

	public boolean isMember(int x);

	public int size();

	public boolean isSubSet(intSet s1);

	public int[] getComplement();

	public int[] union(intSet s1, intSet s2);

}
