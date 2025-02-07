/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package model

import (
	"context"
	"fmt"
	"github.com/apache/plc4x/plc4go/spi/utils"
	"github.com/pkg/errors"
	"github.com/rs/zerolog"
)

// Code generated by code-generation. DO NOT EDIT.

// OpcuaHelloRequest is the corresponding interface of OpcuaHelloRequest
type OpcuaHelloRequest interface {
	fmt.Stringer
	utils.LengthAware
	utils.Serializable
	MessagePDU
	// GetVersion returns Version (property field)
	GetVersion() uint32
	// GetLimits returns Limits (property field)
	GetLimits() OpcuaProtocolLimits
	// GetEndpoint returns Endpoint (property field)
	GetEndpoint() PascalString
}

// OpcuaHelloRequestExactly can be used when we want exactly this type and not a type which fulfills OpcuaHelloRequest.
// This is useful for switch cases.
type OpcuaHelloRequestExactly interface {
	OpcuaHelloRequest
	isOpcuaHelloRequest() bool
}

// _OpcuaHelloRequest is the data-structure of this message
type _OpcuaHelloRequest struct {
	*_MessagePDU
	Version  uint32
	Limits   OpcuaProtocolLimits
	Endpoint PascalString
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for discriminator values.
///////////////////////

func (m *_OpcuaHelloRequest) GetMessageType() string {
	return "HEL"
}

func (m *_OpcuaHelloRequest) GetResponse() bool {
	return bool(false)
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

func (m *_OpcuaHelloRequest) InitializeParent(parent MessagePDU, chunk ChunkType) {
	m.Chunk = chunk
}

func (m *_OpcuaHelloRequest) GetParent() MessagePDU {
	return m._MessagePDU
}

///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////// Accessors for property fields.
///////////////////////

func (m *_OpcuaHelloRequest) GetVersion() uint32 {
	return m.Version
}

func (m *_OpcuaHelloRequest) GetLimits() OpcuaProtocolLimits {
	return m.Limits
}

func (m *_OpcuaHelloRequest) GetEndpoint() PascalString {
	return m.Endpoint
}

///////////////////////
///////////////////////
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

// NewOpcuaHelloRequest factory function for _OpcuaHelloRequest
func NewOpcuaHelloRequest(version uint32, limits OpcuaProtocolLimits, endpoint PascalString, chunk ChunkType) *_OpcuaHelloRequest {
	_result := &_OpcuaHelloRequest{
		Version:     version,
		Limits:      limits,
		Endpoint:    endpoint,
		_MessagePDU: NewMessagePDU(chunk),
	}
	_result._MessagePDU._MessagePDUChildRequirements = _result
	return _result
}

// Deprecated: use the interface for direct cast
func CastOpcuaHelloRequest(structType any) OpcuaHelloRequest {
	if casted, ok := structType.(OpcuaHelloRequest); ok {
		return casted
	}
	if casted, ok := structType.(*OpcuaHelloRequest); ok {
		return *casted
	}
	return nil
}

func (m *_OpcuaHelloRequest) GetTypeName() string {
	return "OpcuaHelloRequest"
}

func (m *_OpcuaHelloRequest) GetLengthInBits(ctx context.Context) uint16 {
	lengthInBits := uint16(m.GetParentLengthInBits(ctx))

	// Simple field (version)
	lengthInBits += 32

	// Simple field (limits)
	lengthInBits += m.Limits.GetLengthInBits(ctx)

	// Simple field (endpoint)
	lengthInBits += m.Endpoint.GetLengthInBits(ctx)

	return lengthInBits
}

func (m *_OpcuaHelloRequest) GetLengthInBytes(ctx context.Context) uint16 {
	return m.GetLengthInBits(ctx) / 8
}

func OpcuaHelloRequestParse(ctx context.Context, theBytes []byte, response bool) (OpcuaHelloRequest, error) {
	return OpcuaHelloRequestParseWithBuffer(ctx, utils.NewReadBufferByteBased(theBytes), response)
}

func OpcuaHelloRequestParseWithBuffer(ctx context.Context, readBuffer utils.ReadBuffer, response bool) (OpcuaHelloRequest, error) {
	positionAware := readBuffer
	_ = positionAware
	log := zerolog.Ctx(ctx)
	_ = log
	if pullErr := readBuffer.PullContext("OpcuaHelloRequest"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for OpcuaHelloRequest")
	}
	currentPos := positionAware.GetPos()
	_ = currentPos

	// Simple Field (version)
	_version, _versionErr := readBuffer.ReadUint32("version", 32)
	if _versionErr != nil {
		return nil, errors.Wrap(_versionErr, "Error parsing 'version' field of OpcuaHelloRequest")
	}
	version := _version

	// Simple Field (limits)
	if pullErr := readBuffer.PullContext("limits"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for limits")
	}
	_limits, _limitsErr := OpcuaProtocolLimitsParseWithBuffer(ctx, readBuffer)
	if _limitsErr != nil {
		return nil, errors.Wrap(_limitsErr, "Error parsing 'limits' field of OpcuaHelloRequest")
	}
	limits := _limits.(OpcuaProtocolLimits)
	if closeErr := readBuffer.CloseContext("limits"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for limits")
	}

	// Simple Field (endpoint)
	if pullErr := readBuffer.PullContext("endpoint"); pullErr != nil {
		return nil, errors.Wrap(pullErr, "Error pulling for endpoint")
	}
	_endpoint, _endpointErr := PascalStringParseWithBuffer(ctx, readBuffer)
	if _endpointErr != nil {
		return nil, errors.Wrap(_endpointErr, "Error parsing 'endpoint' field of OpcuaHelloRequest")
	}
	endpoint := _endpoint.(PascalString)
	if closeErr := readBuffer.CloseContext("endpoint"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for endpoint")
	}

	if closeErr := readBuffer.CloseContext("OpcuaHelloRequest"); closeErr != nil {
		return nil, errors.Wrap(closeErr, "Error closing for OpcuaHelloRequest")
	}

	// Create a partially initialized instance
	_child := &_OpcuaHelloRequest{
		_MessagePDU: &_MessagePDU{},
		Version:     version,
		Limits:      limits,
		Endpoint:    endpoint,
	}
	_child._MessagePDU._MessagePDUChildRequirements = _child
	return _child, nil
}

func (m *_OpcuaHelloRequest) Serialize() ([]byte, error) {
	wb := utils.NewWriteBufferByteBased(utils.WithInitialSizeForByteBasedBuffer(int(m.GetLengthInBytes(context.Background()))))
	if err := m.SerializeWithWriteBuffer(context.Background(), wb); err != nil {
		return nil, err
	}
	return wb.GetBytes(), nil
}

func (m *_OpcuaHelloRequest) SerializeWithWriteBuffer(ctx context.Context, writeBuffer utils.WriteBuffer) error {
	positionAware := writeBuffer
	_ = positionAware
	log := zerolog.Ctx(ctx)
	_ = log
	ser := func() error {
		if pushErr := writeBuffer.PushContext("OpcuaHelloRequest"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for OpcuaHelloRequest")
		}

		// Simple Field (version)
		version := uint32(m.GetVersion())
		_versionErr := writeBuffer.WriteUint32("version", 32, uint32((version)))
		if _versionErr != nil {
			return errors.Wrap(_versionErr, "Error serializing 'version' field")
		}

		// Simple Field (limits)
		if pushErr := writeBuffer.PushContext("limits"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for limits")
		}
		_limitsErr := writeBuffer.WriteSerializable(ctx, m.GetLimits())
		if popErr := writeBuffer.PopContext("limits"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for limits")
		}
		if _limitsErr != nil {
			return errors.Wrap(_limitsErr, "Error serializing 'limits' field")
		}

		// Simple Field (endpoint)
		if pushErr := writeBuffer.PushContext("endpoint"); pushErr != nil {
			return errors.Wrap(pushErr, "Error pushing for endpoint")
		}
		_endpointErr := writeBuffer.WriteSerializable(ctx, m.GetEndpoint())
		if popErr := writeBuffer.PopContext("endpoint"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for endpoint")
		}
		if _endpointErr != nil {
			return errors.Wrap(_endpointErr, "Error serializing 'endpoint' field")
		}

		if popErr := writeBuffer.PopContext("OpcuaHelloRequest"); popErr != nil {
			return errors.Wrap(popErr, "Error popping for OpcuaHelloRequest")
		}
		return nil
	}
	return m.SerializeParent(ctx, writeBuffer, m, ser)
}

func (m *_OpcuaHelloRequest) isOpcuaHelloRequest() bool {
	return true
}

func (m *_OpcuaHelloRequest) String() string {
	if m == nil {
		return "<nil>"
	}
	writeBuffer := utils.NewWriteBufferBoxBasedWithOptions(true, true)
	if err := writeBuffer.WriteSerializable(context.Background(), m); err != nil {
		return err.Error()
	}
	return writeBuffer.GetBox().String()
}
