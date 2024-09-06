package at.codingmiracle.ticktacktoe.model;

public class DefaultBlock implements GamePosition{
	@Override
	public boolean equals(Object o) {
		return o instanceof DefaultBlock;
	}
}
