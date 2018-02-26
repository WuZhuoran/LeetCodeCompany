class Point {
	double x;
	double y;
	Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
}

double getRadius(List<Point> points) {
	Point max = new Point(0.0, 0.0);
	Point min = new Point(0.0, 0.0);
	for (Point p : points) {
		if (max.x < p.x) {
			max.x = p.x;
		}
		if (max.y < p.y) {
			max.y = p.y;
		}
		if (min.x = 0 || min.x > p.x) {
			min.x = p.x;
		if (min.y = 0 || min.y > p.y) {
			min.y = p.y;
		}
	}
	Point center = new Point((max.x - min.x)/2, (max.y - min.y)/2);
	if (max.x > max.y) {
		return max.x - center.x;
	} else {
		return max.y - center.y;
	}
}
