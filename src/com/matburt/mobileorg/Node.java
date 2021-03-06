package com.matburt.mobileorg;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Node {

    static int HEADER = 0;
    static int HEADING = 1;
    static int COMMENT = 2;
    static int DATA = 3;

    ArrayList<Node> subNodes = new ArrayList<Node>();
    ArrayList<String> tags = new ArrayList<String>();
    String nodeName = "";
    String todo = "";
    int nodeType;
    String nodePayload = "";
    Date schedule = null;
    Date deadline = null;

    Node(String heading, int ntype) {
        this.nodeName = heading;
        this.nodeType = ntype;
    }

    Node findChildNode(String regex) {
        Pattern findNodePattern = Pattern.compile(regex);
        for (int idx = 0; idx < this.subNodes.size(); idx++) {
            if (findNodePattern.matcher(this.subNodes.get(idx).nodeName).matches()) {
                return this.subNodes.get(idx);
            }
        }
        return null;
    }

    void addPayload(String npayload) {
        this.nodePayload += npayload + "\n";
    }

    void addChildNode(Node childNode) {
        this.subNodes.add(childNode);
    }

    void clearNodes() {
        this.subNodes.clear();
    }
}