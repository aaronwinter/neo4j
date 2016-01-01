/**
 * Copyright (c) 2002-2016 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.cluster.protocol.omega.state;

public class EpochNumber implements Comparable<EpochNumber>
{
    private int serialNum;
    private final int processId;

    public EpochNumber( int serialNum, int processId )
    {
        this.serialNum = serialNum;
        this.processId = processId;
    }

    public EpochNumber( int processId )
    {
        this( 0, processId );
    }

    public EpochNumber()
    {
        this( -1 );
    }

    @Override
    public int compareTo( EpochNumber o )
    {
        return serialNum == o.serialNum ? processId - o.processId : serialNum - o.serialNum;
    }

    public int getSerialNum()
    {
        return serialNum;
    }

    public int getProcessId()
    {
        return processId;
    }

    public int increaseSerialNum()
    {
        return serialNum++;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( obj == null )
        {
            return false;
        }
        if ( !(obj instanceof EpochNumber) )
        {
            return false;
        }
        EpochNumber other = (EpochNumber) obj;
        return serialNum == other.serialNum && processId == other.processId;
    }

    @Override
    public String toString()
    {
        return "EpochNumber [serial= "+serialNum+", process= "+processId+"]";
    }
}
