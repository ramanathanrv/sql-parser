/**
 * Copyright 2011-2013 FoundationDB, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* The original from which this derives bore the following: */

/*

   Derby - Class org.apache.derby.impl.sql.compile.ModifyColumnNode

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.foundationdb.sql.parser;

import com.foundationdb.sql.StandardException;

/**
 * A ModifyColumnNode represents a modify column in an ALTER TABLE statement.
 *
 */

public class ModifyColumnNode extends ColumnDefinitionNode
{
    private ExistenceCheck existenceCheck;

    public void init(Object name,
                     Object defaultNode,
                     Object type,
                     Object autoIncrementInfo,
                     Object existenceCheck) throws StandardException {
        super.init(name, null, null, null);
        this.existenceCheck = (ExistenceCheck)existenceCheck;
    }

    public void copyFrom(QueryTreeNode node) throws StandardException {
        super.copyFrom(node);

        this.existenceCheck = ((ModifyColumnNode)node).existenceCheck;
    }

    public ExistenceCheck getExistenceCheck() {
        return existenceCheck;
    }

    public String toString() {
        return ( (existenceCheck != null) ? "existence: " + existenceCheck + "\n" : "" ) +
            super.toString();
    }
}
