struct Node {
	int num, pos;
};

class Solution {
public:
	vector<int> twoSum(vector<int> &numbers, int target) {
		int i, j, sum;
		vector<Node> nodes;
		Node node;

		for (i = 0; i < numbers.size(); i++) {
			node.num = numbers[i];
			node.pos = i + 1;
			nodes.push_back(node);
		}	

		sort(nodes.begin(), nodes.end(), [](const Node &a, const Node &b){return a.num < b.num;});
		
		//for (Node &node : nodes)
		//	cout << node.num << ' ' << node.pos << endl;

		i = 0;
		j = numbers.size() - 1;
		while (true) {
			sum = nodes[i].num + nodes[j].num;
			//cout << i << j << sum << endl;
			if (sum == target)
				if (nodes[i].pos < nodes[j].pos)
					return vector<int>{nodes[i].pos, nodes[j].pos};
				else
					return vector<int>{nodes[j].pos, nodes[i].pos};
			else if (sum < target)
				i++;
			else
				j--;
		}
	}
};
