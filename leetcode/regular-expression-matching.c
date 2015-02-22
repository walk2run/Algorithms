bool isMatch(char *s, char *p) {
	if (*p == '\0') return *s == '\0';
	if (*(p + 1) != '*')
	    return (*s == *p || *p == '.' && *s != '\0') && isMatch(s + 1, p + 1);
	if (isMatch(s, p + 2)) return true;
	while (*s == *p || *p == '.' && *s != '\0')
		if (isMatch(++s, p + 2)) return true;
	return false;
}