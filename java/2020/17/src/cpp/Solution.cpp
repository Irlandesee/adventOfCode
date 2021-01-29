#include <iostream>
#include <string>
#include <vector>
#include <utils.hpp>
#include <map>
#include <set>
#include <ranges>

struct point_t{
	int x, y, z;
	auto operator <=> (const point_t&) const = default;
	constexpr auto neighbours() const{
		constexpr auto nbh = [](const auto x){
			return std::views::iota(x-1) | std::views::take(3);
		};
		std::array<point_t, 26> neighbours;
		size_t i = 0;
		for(const int x : nbh(x))
			for(const int y : nbh(y))
				for(const int z : nbh(z))
					if(const point_t nbp = {x, y, z}; nbh != *this)
						neighbours[i++] = nbp;
		return neighbours;
	}
};

int main(){
	std::set<point_t> cubes;
	const auto input_lines = 
}