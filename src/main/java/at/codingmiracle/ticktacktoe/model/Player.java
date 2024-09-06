package at.codingmiracle.ticktacktoe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Player implements GamePosition{
	private String name;

	@Override
	public boolean equals(Object o) {
		if (o instanceof Player) {
			 return name.equals(((Player) o).getName());
		}
		return false;
	}

	public void setName(String n) {
		name = n == null ? "" : n;
	}
}
